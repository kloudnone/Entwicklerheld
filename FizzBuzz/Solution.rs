pub fn fizzbuzz(number: i32) -> String {
    match number {
        n if n % 15 == 0 => "fizzbuzz".to_string(),
        n if n % 3 == 0 => "fizz".to_string(),
        n if n % 5 == 0 => "buzz".to_string(),
        _ => number.to_string(),
    }
}