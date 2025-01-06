/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GetHired.controller;

import com. GetHired.model.GetHiredModel;
import java.util.List;

/**
 *
 * @author Prithivi
 */
public class BinarySearch {

    public GetHiredModel searchByName(String searchValue, List<GetHiredModel> companyList,
            int left, int right) {

        if (right < left) {
            return null;
        }

        int mid = (left + right) / 2;

        if (searchValue.toLowerCase().equals(companyList.get(mid).getCompanyName().toLowerCase())) {
            return companyList.get(mid);
        } else if (searchValue.compareToIgnoreCase(companyList.get(mid).getCompanyName()) < 0) {
            return searchByName(searchValue, companyList, left, mid - 1);
        } else {
            return searchByName(searchValue, companyList, mid + 1, right);
        }

    }
}