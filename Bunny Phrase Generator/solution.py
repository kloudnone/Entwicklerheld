def generate_all_sentences(subjects, verbs, objects):
    return [
        f"{sub} {verb} {obj}."
        for sub in subjects
        for verb in verbs
        for obj in objects
    ]


def generate_kth_sentence(subjects, verbs, objects, k):
    n_v, n_o = len(verbs), len(objects)
    block = n_v * n_o
    si = k // block
    rem = k % block
    vi = rem // n_o
    oi = rem % n_o
    sub, verb, obj = subjects[si], verbs[vi], objects[oi]
    return f"{sub} {verb} {obj}."