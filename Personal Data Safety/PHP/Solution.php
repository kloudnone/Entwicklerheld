<?php
declare(strict_types=1);
include("user_data.php");

function get_personal_data(string $user_id): array {
    $userData = get_user_by_id($user_id);

    $street = $userData['street'];
    $zip = $userData['zip'];
    $city = $userData['city'];
    $email = $userData['email'];
    $phone = $userData['phone'];
    $bankAccount = $userData['bank account'];
    $iban = $userData['reference account']['iban'];
    $bic = $userData['reference account']['bic'];
    $institution = $userData['reference account']['institution'];

    if (has_strong_authetication($user_id) === false) {
        $street = generateStreet($street);
        $zip = generateZip($zip);
        $city = generateCity($city);
        $email = generateEmail($email);
        $phone = generatePhone($phone);
        $bankAccount = generateBankAccount($bankAccount);
        $iban = generateIban($iban);
        $bic = generateBic($bic);
        $institution = generateInstitution($institution);
    }

    $data = [
        'name' => $userData['name'],
        'street' => $street,
        'street number' => $userData['street number'],
        'zip' => $zip,
        'city' => $city,
        'email' => $email,
        'phone' => $phone,
        'bank account' => $bankAccount,
        'reference account' => [
            'owner' => $userData['reference account']['owner'],
            'iban' => $iban,
            'bic' => $bic,
            'institution' => $institution,
        ],
    ];

    return $data;
}

function generateStreet(string $street): string
{
    $start = substr($street, 0, 3);
    $end = str_repeat("*", strlen($street)-3);

    return $start . $end;
}

function generateZip(string $zip): string
{
    $start = substr($zip, 0, 3);
    $end = str_repeat("*", strlen($zip)-3);

    return $start . $end;
}

function generateCity(string $city): string
{
    $end = substr($city, -3, 3);
    $start = str_repeat("*", strlen($city)-3);

    return $start . $end;
}

function generateEmail(string $email): string
{
    $position = strpos($email, "@");
    $end = substr($email, $position, strlen($email)-1);
    $start = str_repeat("*", $position);

    return $start . $end;
}

function generatePhone(string $phone): string
{
    $end = substr($phone, -3, 3);
    $start = str_repeat("*", strlen($phone)-3);

    return $start . $end;
}

function generateBankAccount(string $bankAccount): string
{
    $start = substr($bankAccount, 0, 2);
    $mid = str_repeat("*", strlen($bankAccount)-5);
    $end = substr($bankAccount, -3, 3);

    return $start . $mid. $end;
}

function generateIban(string $iban): string
{
    $start = substr($iban, 0, 3);
    $mid = str_repeat("*", strlen($iban)-6);
    $end = substr($iban, -3, 3);

    return $start . $mid. $end;
}

function generateBic(string $bic): string
{
    $end = substr($bic, -3, 3);
    $start = str_repeat("*", strlen($bic)-3);

    return $start . $end;
}

function generateInstitution(string $iban): string
{
    $start = substr($iban, 0, 3);
    $mid = str_repeat("*", strlen($iban)-6);
    $end = substr($iban, -3, 3);

    return $start . $mid. $end;
}
?>