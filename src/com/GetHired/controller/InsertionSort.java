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
public class InsertionSort {

       List<GetHiredModel> companysSortList;

    public InsertionSort() {
        companysSortList = new ArrayList<>();
    }

    /**
     * Sorts a list of GetHiredModel objects by their company ID in ascending or
     * descending order using insertion sort.
     *
     * @param companysSortList the list of GetHiredModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public List<GetHiredModel> sortByCompanyId(List<GetHiredModel> companysSortList, boolean isDesc) {
        if (companysSortList == null || companysSortList.isEmpty()) {
            throw new IllegalArgumentException("Company list cannot be null or empty.");
        }

        for (int i = 1; i < companysSortList.size(); i++) {
            GetHiredModel current = companysSortList.get(i);
            int j = i - 1;

            // Shift elements based on the sort order
            while (j >= 0 && shouldSwap(current.getCompanyId(), companysSortList.get(j).getCompanyId(), isDesc)) {
                companysSortList.set(j + 1, companysSortList.get(j));
                j--;
            }

            // Place the current element in its correct position
            companysSortList.set(j + 1, current);
        }

        return companysSortList;
    }

    /**
     * Determines whether the current value should be placed before the previous value
     * based on sort order.
     *
     * @param current the current value
     * @param previous the previous value
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return true if the current value should be placed before the previous; false
     * otherwise
     */
    private boolean shouldSwap(int current, int previous, boolean isDesc) {
        return isDesc ? current > previous : current < previous;
    }
}

