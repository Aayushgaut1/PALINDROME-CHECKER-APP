import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;
public class Palindromecheckerapp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 13.0");
        System.out.println("System Initialized Successfully");
        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        // ===============================
        // UC7 : Deque Based Palindrome
        // ===============================
        System.out.println("\n----- UC7 : Deque Based Palindrome Checker -----");
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }
        boolean isPalindromeUC7 = true;
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindromeUC7 = false;
                break;
            }
        }
        System.out.println("Is Palindrome? : " + isPalindromeUC7);
        // ===============================
        // UC8 : LinkedList Based Palindrome
        // ===============================
        System.out.println("\n----- UC8 : LinkedList Based Palindrome Checker -----");
        LinkedList<Character> list = new LinkedList<>();
        for (char c : input.toCharArray()) {
            list.add(c);
        }
        boolean isPalindromeUC8 = true;
        while (list.size() > 1) {
            char first = list.removeFirst();
            char last = list.removeLast();
            if (first != last) {
                isPalindromeUC8 = false;
                break;
            }
        }
        System.out.println("Is Palindrome? : " + isPalindromeUC8);
        // ===============================
        // UC9 : Recursive Palindrome
        // ===============================
        System.out.println("\n----- UC9 : Recursive Palindrome Checker -----");
        boolean isPalindromeUC9 = checkRecursive(input, 0, input.length() - 1);
        System.out.println("Is Palindrome? : " + isPalindromeUC9);
        // ===============================
        // UC10 : Normalized Palindrome
        // ===============================
        System.out.println("\n----- UC10 : Normalized Palindrome -----");
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean isPalindromeUC10 = true;
        for (int i = 0; i < normalized.length() / 2; i++) {

            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                isPalindromeUC10 = false;
                break;
            }
        }
        System.out.println("Is Palindrome? : " + isPalindromeUC10);
        // ===============================
        // UC11 : Object Oriented Service
        // ===============================
        System.out.println("\n----- UC11 : Object-Oriented Service -----");
        PalindromeChecker checker = new PalindromeChecker();
        boolean resultUC11 = checker.checkPalindrome(input);
        System.out.println("Is Palindrome? : " + resultUC11);
        // ===============================
        // UC12 : Strategy Pattern
        // ===============================
        System.out.println("\n----- UC12 : Strategy Pattern -----");
        PalindromeStrategy strategy = new DequeStrategy();
        PalindromeCheckerService service = new PalindromeCheckerService(strategy);
        boolean resultUC12 = service.check(input);
        System.out.println("Is Palindrome? : " + resultUC12);
        // ===============================
        // UC13 : Performance Comparison
        // ===============================
        System.out.println("\n----- UC13 : Performance Comparison -----");
        long start;
        long end;
        // Stack Strategy Benchmark
        start = System.nanoTime();
        PalindromeStrategy stackStrategy = new StackStrategy();
        stackStrategy.isPalindrome(input);
        end = System.nanoTime();
        long stackTime = end - start;
        // Deque Strategy Benchmark
        start = System.nanoTime();
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        dequeStrategy.isPalindrome(input);
        end = System.nanoTime();
        long dequeTime = end - start;
        System.out.println("Input : " + input);
        System.out.println("Stack Execution Time : " + stackTime + " ns");
        System.out.println("Deque Execution Time : " + dequeTime + " ns");
        scanner.close();
    }
    // UC9 Recursive Method
    private static boolean checkRecursive(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        return checkRecursive(s, start + 1, end - 1);
    }
}
// UC11 Service Class
class PalindromeChecker {
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0;
        int end = normalized.length() - 1;
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
// UC12 Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}
// Stack Strategy
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
// Deque Strategy
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();
            if (front != rear) {
                return false;
            }
        }
        return true;
    }
}
// Strategy Service
class PalindromeCheckerService {
    private PalindromeStrategy strategy;
    public PalindromeCheckerService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean check(String input) {
        return strategy.isPalindrome(input);
    }
}