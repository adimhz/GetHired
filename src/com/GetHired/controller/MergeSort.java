/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GetHired.controller;
import com.GetHired.model.GetHiredModel;
import java.util.ArrayList;
import java.util.List;


public class MergeSort {
    public List<GetHiredModel> sortById(List<GetHiredModel> JobList, boolean isDesc) {
        if (JobList == null || JobList.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty.");
        }

        return mergeSort(JobList, isDesc);
    }

    private List<GetHiredModel> mergeSort(List<GetHiredModel> JobList, boolean isDesc) {
        if (JobList.size() <= 1) {
            return JobList;
        }

        int mid = JobList.size() / 2;
        List<GetHiredModel> left = new ArrayList<>(JobList.subList(0, mid));
        List<GetHiredModel> right = new ArrayList<>(JobList.subList(mid, JobList.size()));

        // Recursively split and merge
        left = mergeSort(left, isDesc);
        right = mergeSort(right, isDesc);

        return merge(left, right, isDesc);
    }

    private List<GetHiredModel> merge(List<GetHiredModel> left, List<GetHiredModel> right, boolean isDesc) {
        List<GetHiredModel> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Merge based on the model names
        while (i < left.size() && j < right.size()) {
            if (shouldPlaceLeft(left.get(i).getJobId(), right.get(j).getJobId(), isDesc)) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        // Add remaining elements
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }

   
        private boolean shouldPlaceLeft(int leftModel, int rightModel, boolean isDesc) {
    int comparison = Integer.compare(leftModel, rightModel);
    if (isDesc) {
        return comparison > 0; // Descending order
    } else {
        return comparison < 0; // Ascending order
    }
}
}
