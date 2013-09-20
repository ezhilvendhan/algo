package sort

func DoInsertionSort(input []int) []int {
	for idx := 1; idx < len(input); idx++ {
		idxVal := input[idx]
		prev := idx-1
		for ; prev >=0 && idxVal < input[prev] ; {
			input[prev + 1] = input[prev]
			prev = prev-1
		}
		input[prev+1] = idxVal
	}
	return input
}
