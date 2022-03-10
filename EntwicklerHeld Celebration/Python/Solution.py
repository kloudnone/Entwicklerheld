def count_clinking_glasses_for_eh_team(number_of_guests):
    return (number_of_guests*(number_of_guests-1))/2


def count_clinking_glasses_for_variable_number_of_guests(number_of_guests):
    number = 0
    if number_of_guests == 2:
        return 1

    for i in range (number_of_guests, 1, -1):
        number += (i*(i-1))/2

    return number