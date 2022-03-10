def get_pascals_triangle_row(rowIndex: int) -> list:
    r = [1]
    for i in range(1,rowIndex+1):
        r.append( r[-1]*(rowIndex-i+1)/i )
    return r