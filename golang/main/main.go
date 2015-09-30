package main

import (
	"fmt"
	"github.com/ezhilvendhan/algo/golang/sort"
	"github.com/ezhilvendhan/goutil/conv"
	"flag"
	"strings"
	"time"
)

func main() {
	algorithm, inputStr := parseInput()
	fmt.Println("------------------------------------")
	execute(algorithm, conv.ToIntArray(strings.Split(inputStr, " ")))
	fmt.Println("------------------------------------")
}

func parseInput() (string, string) {
	algorithm := flag.String("alg", "", "The algorithm to be called for the input")
	inputStr := flag.String("in", "", "Space separated input")
	flag.Parse()
	return *algorithm, *inputStr
}

func execute(algorithm string, input []int) {
	switch algorithm {
	case "insert", "ins": {
		fmt.Println(">> Insertion Sort <<")
		start := time.Now()
		fmt.Println(sort.DoInsertionSort(input))
		fmt.Println("Elapsed Time [", time.Now().Sub(start), "]")
	}
	case "merge", "ms": {
		fmt.Println(">> Merge Sort <<")
		start := time.Now()
		fmt.Println(sort.DoMergeSort(input))
		fmt.Println("Elapsed Time [", time.Now().Sub(start), "]")
	}
	case "sel", "ss" : {
		fmt.Println(">> Selection Sort <<")
		start := time.Now()
		fmt.Println(sort.DoSelectionSort(input))
		fmt.Println("Elapsed Time [", time.Now().Sub(start), "]")
	}
	default: {
		fmt.Println(algorithm)
		fmt.Println("Type an algorithm to call for the supplied input. Eg: -alg=ins for insertion sort")
	}
	}
}
