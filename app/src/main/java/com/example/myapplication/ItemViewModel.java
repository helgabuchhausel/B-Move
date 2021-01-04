package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

class ItemViewModel extends AndroidViewModel {

    private ItemRepository itemRepository;

    private final LiveData<List<Item>> allItems;


    public ItemViewModel(@NonNull Application application) {
        super(application);
        itemRepository = new ItemRepository(application);
        allItems = itemRepository.getAllItems();

    }

    LiveData<List<Item>> getAllWords() { return allItems; }

    public void insert(Item item) { itemRepository.insert(item); }

}
