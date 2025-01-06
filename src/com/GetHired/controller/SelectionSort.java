/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GetHired.controller;

import com.GetHired.model.GetHiredModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adita
 */
public class SelectionSort {

    List<GetHiredModel> companysSortList;

    public SelectionSort() {
        companysSortList = new ArrayList<>();
    }

    
    public List<GetHiredModel> sortByCompanyName(List<GetHiredModel> companysSortList, boolean isDesc) {
        this.companysSortList.clear();
        this.companysSortList.addAll(companysSortList);
        if (companysSortList == null || companysSortList.isEmpty()) {
            throw new IllegalArgumentException("Company list cannot be null or empty.");
        }

        for (int i = 0; i < companysSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(companysSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(companysSortList, i, extremumIndex);
            }
        }

        return companysSortList;
    }
    
    private int findExtremumIndex(List<GetHiredModel> companysSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < companysSortList.size(); j++) {
            if (shouldSwap(
                    companysSortList.get(j).getCompanyName(), 
                    companysSortList.get(extremumIndex).getCompanyName(), 
                    isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

   
    private boolean shouldSwap(String current, String extremum, boolean isDesc) {
         int comparison = current.compareToIgnoreCase(extremum);
        return isDesc ? comparison > 0 : comparison < 0;
    }

    
    private void swap(List<GetHiredModel> companysSortList, int i, int j) {
        GetHiredModel temp = companysSortList.get(i);
        companysSortList.set(i, companysSortList.get(j));
        companysSortList.set(j, temp);
    }
}
