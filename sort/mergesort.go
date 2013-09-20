package sort

import (
	"math"
)

func DoMergeSort(input []int) []int {
	return mergeSort(input, 0, len(input))
}

func mergeSort(input []int, start, end int) []int {
	if end > (start+1) {
		mid := (start+end)/2
		input = mergeSort(input, start, mid)
		input = mergeSort(input, mid, end)
		input = merge(input, start, mid, end)
	}
	return input
}

func merge(input []int, start, mid, end int) []int {
	array1 := make([]int, mid-start)
	array2 := make([]int, end-mid)
	copy(array1, input[start:mid])
	copy(array2, input[mid:end])
	array1 = append(array1, math.MaxUint32)
	array2 = append(array2, math.MaxUint32)
	i,j := 0, 0
	for idx := start; idx < end; idx++ {
		if array1[i] <= array2[j] {
			input[idx] = array1[i]
			i++
		} else {
			input[idx] = array2[j]
			j++
		}
	}
	return input
}
