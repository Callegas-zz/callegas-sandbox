package main

import "fmt"

func recursiveFactorial(n int) int {
	if (n > 1) {
		n = n * recursiveFactorial(n-1)
	}
	return n
}


func factorial(n int) int {
	total := 1
	for i := n; i > 1; i-- {
		total *= i
	}
	return total
}

func main() {
	fmt.Println(recursiveFactorial(5))
	fmt.Println(factorial(5))
}