from typing import Literal

def incr(x, /):
    return x + 1

class Python38:
    # Scenario 1
    def new_feature_walrus_operator(self) -> None:
        lines = []
        if (current_line := input("Tell me something: ")) != "quit":
            lines.append(current_line)
    
    # Scenario 2
    def new_feature_positional_only_arguments(self) -> None:
        _ = incr(x=1)
    
    # Scenario 3
    def new_feature_more_type_annotations(self, language: Literal["DE", "EN"]) -> None:
        if language == "DE":
            print("Hallo Welt")
        elif language == "EN":
            print("Hello World")
        else:
            raise ValueError("Unsupported language.")
    
    # Scenario 4
    def new_feature_more_improved_f_string(self) -> None:
        a, b = (4, 4)
        sum = a + b
        print(f'{sum=}')