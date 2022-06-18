def find_first_non_repeated_char(sequence: str):
    transformSequence = "".join([x.lower() for x in sequence])
    for i in transformSequence:
        if transformSequence.count(i) == 1:
            if i.isalpha():
                if i in sequence:
                    return i
                if i.upper() in sequence:
                    return i.upper()
            else:
                return i
    return None
