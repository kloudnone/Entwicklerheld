package de.entwicklerheld.easystorage.challenge.stage1;

import java.util.Objects;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import java.lang.RuntimeException;

class EasyStorage{

    private HashMap<String, String> storage = new HashMap<>();

    public void store(String item, String repository){
        
        storage.put(item, repository);
        
        if(storage == null || item == null || repository == null) {
            throw new NullPointerException("The item store is empty.");
        }

        if(item.length() < 1 || repository.length() < 1) {
            throw new IllegalArgumentException("The input parameters are not valid.");
        }

    }

    public Map<String, String> getAllData(){
        return this.storage;
    }

    public String getRepository(String item) {
        if(storage.containsKey(item)) {
            return storage.get(item);
        } else {
            return null;
        }
    }

    public Set<String> getItems(String repository){
        Set<String> items = new HashSet<>();
        
        for(Map.Entry<String, String> entry : storage.entrySet()) {
            if(Objects.equals(repository, entry.getValue())) {
                items.add(entry.getKey());
            }
        }
        return items;
    }
}