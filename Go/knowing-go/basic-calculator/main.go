package main

import "fmt"

func sum(valueA float32, valueB float32) float32 {
	return valueA + valueB
}

func sub(valueA float32, valueB float32) float32 {
	return valueA - valueB
}

func mul(valueA float32, valueB float32) float32 {
	return valueA * valueB
}

func div(valueA float32, valueB float32) float32 {
	if valueA == 0 || valueB == 0 {
		return 0
	}
	return valueA / valueB
}

func calc(valueA float32, valueB float32, operation string) float32 {
	switch operation {
	case "+":
		return sum(valueA, valueB)
	case "-":
		return sub(valueA, valueB)
	case "*":
		return mul(valueA, valueB)
	case "/":
		return div(valueA, valueB)
	default:
		return 0
	}
}

func main() {
	fmt.Println("10 + 10 = ", calc(10, 10, "+"))
	fmt.Println("10 - 10 = ", calc(10, 10, "-"))
	fmt.Println("10 * 10 = ", calc(10, 10, "*"))
	fmt.Println("10 / 10 = ", calc(10, 10, "/"))
}
