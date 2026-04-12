class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1; // Pointer for string a
        int j = b.length() - 1; // Pointer for string b
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            if (i >= 0) {
                sum += a.charAt(i--) - '0'; // Convert char to int
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            
            sb.append(sum % 2); // Append the binary result (0 or 1)
            carry = sum / 2;    // Calculate the new carry
        }
        
        // The result is built backwards, so reverse it
        return sb.reverse().toString();
    }
}