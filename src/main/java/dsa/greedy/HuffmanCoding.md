# Huffman Coding
- Huffman coding is a lossless data compression algorithm
- The idea is to assign variable-length codes to input characters, lengths of the assigned codes are based on the frequencies of corresponding characters(Greater the frequency of letter/symbol smaller is the length of code assigned). 
- The variable-length codes assigned to input characters are *<b>Prefix Codes</b>*, means the codes (bit sequences) are assigned in such a way that the code assigned to one character is not the prefix of code assigned to any other character.
- Let there be four characters a, b, c and d, and their corresponding variable length codes be 00, 01, 0 and 1. This coding leads to ambiguity because code assigned to c is the prefix of codes assigned to a and b. If the compressed bit stream is 0001, the de-compressed output may be “cccd” or “ccb” or “acd” or “ab”.

Click here [Huffman Coding - Geeks for Geeks](https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/) for more information.