package sort

func DoSelectionSort(input []int) []int {
	return sort(input, 0, len(input))
}

func sort(input []int, start, end int) []int {
	if start < (end-1) {
		smallestNum := input[start]
		for idx := (start+1); idx < end; idx++ {
			if input[idx] < smallestNum {
				input[start] = input[idx]
				input[idx] = smallestNum
				smallestNum = input[start]
			}
		}
		sort(input, start+1, end)
	}
	return input
}
