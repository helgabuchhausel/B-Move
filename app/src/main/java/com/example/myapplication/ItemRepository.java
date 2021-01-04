package com.example.myapplication;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class ItemRepository {
    private ItemDao itemDao;
    private LiveData<List<Item>> allItems;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    ItemRepository(Application application) {
        ItemDatabase db = ItemDatabase.getDatabase(application);
        itemDao = db.itemDao();
        allItems = itemDao.getAlphabetizedItems();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Item>> getAllItems() {
        return allItems;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(final Item item) {
        ItemDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                itemDao.insert(item);
            }
        });

    }
}
