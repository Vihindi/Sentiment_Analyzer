public class Search {
    // Binary search method to find the index of a word in the MyLinkedList.
    public static int binarySearch(MyLinkedList PositiveNegativeList, String word) {
        int left = 0;
        int right = MyLinkedList.getSize(PositiveNegativeList);
        String regex = "[^a-zA-Z ]";

        while (left <= right) {
            // Calculate the middle index.
            int midValue = left + (right - left) / 2;

            // Get the word at the middle index.
            String com_word = MyLinkedList.getValueAtIndex(PositiveNegativeList, midValue);

            // Get the word at the middle index
            if (com_word == null) {
                // Handle the case where com_word is null
                return -1;
            }

            // Remove special characters and convert to lowercase for comparison.
            com_word = com_word.replaceAll(regex, "").toLowerCase();

            // Handle the case where word is null.
            if (word == null) {
                return -1;
            }

            int comparison = word.compareTo(com_word);

            // If the target word matches the word at the middle index, return the index.
            if (comparison == 0) {
                return midValue;
            } else if (comparison < 0) {
                // If the target word is smaller, search in the left half.
                right = midValue - 1;
            } else {
                // If the target word is larger, search in the right half.
                left = midValue + 1;
            }
        }
        // If the word is not found, return -1.
        return -1;
    }
}
