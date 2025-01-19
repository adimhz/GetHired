/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GetHired.controller;

import com. GetHired.model.GetHiredModel;
import java.util.List;

/**
 *
 * @author Adita
 */
public class BinarySearch {

    /**
     * Searches for a company in a sorted list of GetHiredModel objects by its name 
     * using the binary search algorithm.
     * 
     * @param searchValue 
     * @param companyList
     * @param left 
     * @param right 
     * @return The GetHiredModel object that matches the search value, or null if not found.
     */
    public GetHiredModel searchByName(String searchValue, List<GetHiredModel> companyList,
            int left, int right) {

        // Base case: If the search range is invalid, return null (not found).
        if (right < left) {
            return null;
        }

        // Calculate the middle index of the current search range.
        int mid = (left + right) / 2;

        // Check if the middle element matches the search value.
        if (searchValue.toLowerCase().equals(companyList.get(mid).getCompanyName().toLowerCase())) {
            return companyList.get(mid); // Match found, return the object.
        } 
        // If the search value is smaller than the middle element, search the left half.
        else if (searchValue.compareToIgnoreCase(companyList.get(mid).getCompanyName()) < 0) {
            return searchByName(searchValue, companyList, left, mid - 1);
        } 
        // If the search value is greater than the middle element, search the right half.
        else {
            return searchByName(searchValue, companyList, mid + 1, right);
        }
    }
}
