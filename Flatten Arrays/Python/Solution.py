class FlattenArrayPython:

    @staticmethod
    def flatten(iterable):
        result = []
        for item in iterable:
            if item is None:
                continue
            if isinstance(item, list):
                result.extend(FlattenArrayPython.flatten(item))
            else:
                result.append(item)
        return result
