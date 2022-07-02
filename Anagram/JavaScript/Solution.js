export function isAnagram(firstWord, secondWord) {
    return sortString(firstWord) == sortString(secondWord);
}

export function sortString(word) {
    return word.replace(/[^\w]/g).toLowerCase().split('').sort().join();
}
