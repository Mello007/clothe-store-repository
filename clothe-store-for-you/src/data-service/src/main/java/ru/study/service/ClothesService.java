package ru.study.service;

import ru.study.entity.Clothes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClothesService {

    private static final List<Clothes> ALL_CLOTHES = new ArrayList<>();


    public boolean addClothe(Clothes clothes){
        return ALL_CLOTHES.add(clothes);
    }

    public boolean findClothe(Clothes clothes){
        return ALL_CLOTHES.contains(clothes);
    }

    public boolean deleteClothe(Clothes clothes){
        return ALL_CLOTHES.remove(clothes);
    }

    public List<Clothes> lookClothe(){
        return ALL_CLOTHES;
    }
}

