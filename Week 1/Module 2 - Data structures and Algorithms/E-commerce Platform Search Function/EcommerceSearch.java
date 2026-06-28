public class EcommerceSearch {

//Linear Search
    public static Product linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return products[i];
            }
        }
        return null;
    }

//Binary Search
    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedProducts[mid].getProductId() == targetId) {
                return sortedProducts[mid];
            }

            if (sortedProducts[mid].getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("=== E-commerce Platform Search Function ===\n");

        
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(205, "T-Shirt", "Clothing"),
            new Product(303, "Headphones", "Electronics"),
            new Product(404, "Jeans", "Clothing"),
            new Product(505, "Smartphone", "Electronics")
        };

        Product[] sortedProducts = {
            new Product(101, "Laptop", "Electronics"),
            new Product(205, "T-Shirt", "Clothing"),
            new Product(303, "Headphones", "Electronics"),
            new Product(404, "Jeans", "Clothing"),
            new Product(505, "Smartphone", "Electronics")
        };

        System.out.println("=== Understanding Big O Notation ===");
        System.out.println("Big O notation describes how algorithm performance scales with input size.");
        System.out.println("It helps us compare algorithms by focusing on worst-case growth rate.\n");

        System.out.println("=== Linear Search Analysis ===");
        System.out.println("Time Complexity: O(n)");
        System.out.println("Best case: O(1) - item at first position");
        System.out.println("Average case: O(n) - item somewhere in array");
        System.out.println("Worst case: O(n) - item at end or not found");
        System.out.println("Works on: Unsorted arrays\n");

        System.out.println("=== Binary Search Analysis ===");
        System.out.println("Time Complexity: O(log n)");
        System.out.println("Best case: O(1) - item at middle");
        System.out.println("Average case: O(log n) - requires halving array");
        System.out.println("Worst case: O(log n) - requires full halving");
        System.out.println("Works on: Sorted arrays only\n");

        // Test Linear Search
        System.out.println("=== Testing Linear Search ===");
        int searchId1 = 303;
        long startTime = System.nanoTime();
        Product result1 = linearSearch(products, searchId1);
        long endTime = System.nanoTime();
        
        if (result1 != null) {
            System.out.println("Found: " + result1);
            System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
        } else {
            System.out.println("Product not found");
        }
        System.out.println();

        // Test Binary Search
        System.out.println("=== Testing Binary Search ===");
        int searchId2 = 303;
        startTime = System.nanoTime();
        Product result2 = binarySearch(sortedProducts, searchId2);
        endTime = System.nanoTime();
        
        if (result2 != null) {
            System.out.println("Found: " + result2);
            System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
        } else {
            System.out.println("Product not found");
        }
        System.out.println();

        System.out.println("=== Comparison & Recommendation ===");
        System.out.println("For small datasets (< 100 items): Linear search is simpler and fine.");
        System.out.println("For large datasets (> 1000 items): Binary search is much faster.");
        System.out.println("For e-commerce platform with millions of products:");
        System.out.println("- Use Binary Search if data is sorted by productId");
        System.out.println("- Use Linear Search if data is unsorted or frequently changes");
        System.out.println("- Consider hash tables (O(1)) for constant-time lookups in real systems");
    }
}
