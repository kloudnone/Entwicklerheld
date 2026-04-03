def kaprekar_step(n: int, k: int) -> int:
    if n < 0:
        raise ValueError("n must be non-negative")
    if k <= 0:
        raise ValueError("k must be positive")

    asc = sorted(f"{n % (10**k):0{k}d}")
    low = int("".join(asc))
    high = int("".join(reversed(asc)))
    return high - low


def kaprekar_sequence(n: int, k: int) -> list[int]:
    sequence: list[int] = [n]
    seen: set[int] = {n}
    while True:
        last = sequence[-1]
        nxt = kaprekar_step(last, k)
        if nxt == last or nxt in seen:
            sequence.append(nxt)
            break
        sequence.append(nxt)
        seen.add(nxt)
    return sequence
