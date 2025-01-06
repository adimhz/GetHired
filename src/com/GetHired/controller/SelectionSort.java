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

    /**
     * Sorts a list of GetHiredModel objects by their LMU ID in ascending or
     * descending order.
     *
     * @param companysSortList the list of GetHiredModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
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

    /**
     * Finds the index of the extremum value (minimum or maximum) in the list
     * from the start index.
     *
     * @param companysSortList the list of GetHiredModel objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum
     * (false)
     * @return the index of the extremum value
     */
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

    /**
     * Determines whether the current value should replace the current extremum
     * based on sort order.
     *
     * @param current the current value
     * @param extremum the current extremum value
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return true if the current value should replace the extremum; false
     * otherwise
     */
    private boolean shouldSwap(String current, String extremum, boolean isDesc) {
         int comparison = current.compareToIgnoreCase(extremum);
        return isDesc ? comparison > 0 : comparison < 0;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param companysSortList the list of GetHiredModel objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<GetHiredModel> companysSortList, int i, int j) {
        GetHiredModel temp = companysSortList.get(i);
        companysSortList.set(i, companysSortList.get(j));
        companysSortList.set(j, temp);
    }
}
