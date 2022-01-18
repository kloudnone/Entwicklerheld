<?php

declare(strict_types=1);

namespace entwicklerheld;

class PolicyRequest extends AbstractPolicyRequest implements IPolicyRequest
{
    private $state;

    private const STATE_INCOMPLETE = 'INCOMPLETE';
    private const STATE_NEW = 'NEW';
    private const STATE_IN_REVIEW = 'IN_REVIEW';
    private const STATE_READY_FOR_TRANSMISSION = 'READY_FOR_TRANSMISSION';
    private const STATE_TRANSMITTED = 'TRANSMITTED';
    private const STATE_ERROR = 'ERROR';
    private const STATE_DUPLICATE_FAKE = 'DUPLICATE_FAKE';
    private const STATE_SUCCESSFUL = 'SUCCESSFUL';
    private const STATE_INACTIVE = 'INACTIVE';
    private const STATE_CANCELED = 'CANCELED';
    private const STATE_NOT_SUCCESSFUL = 'NOT_SUCCESSFUL';

    private const STATE_MAP = [
        self::STATE_INCOMPLETE => [
            self::STATE_NEW,
            self::STATE_DUPLICATE_FAKE,
            self::STATE_ERROR
        ],
        self::STATE_NEW => [
            self::STATE_IN_REVIEW,
            self::STATE_DUPLICATE_FAKE,
            self::STATE_ERROR
        ],
        self::STATE_IN_REVIEW => [
            self::STATE_READY_FOR_TRANSMISSION,
            self::STATE_DUPLICATE_FAKE,
            self::STATE_ERROR
        ],
        self::STATE_READY_FOR_TRANSMISSION => [
            self::STATE_ERROR,
            self::STATE_TRANSMITTED
        ],
        self::STATE_TRANSMITTED => [
            self::STATE_ERROR,
            self::STATE_SUCCESSFUL,
            self::STATE_NOT_SUCCESSFUL
            ],
        self::STATE_SUCCESSFUL => [
            self::STATE_ERROR,
            self::STATE_INACTIVE,
            self::STATE_CANCELED
        ],

    ];

    public function __construct(string $state)
    {
        $this->state = $state;
    }

    public function getLeadState(): string
    {
        return $this->state;
    }

    public function getPossibleNextStates(): array
    {
        return self::STATE_MAP[$this->state] ?? [];
    }

    public function transitionState(string $to): bool
    {
        if (!\in_array($to, self::STATE_MAP[$this->state] ?? [])) {
            // early return to avoid unnecessary checks
            return false;
        } else {
            $res = true;
        }

        if ($this->checkIBAN($this->getIBAN()) === true) {
            $res = true;
        } else {
            $res = false;
        }

        if ($res === true) {
            $this->state = $to;
        }

        return $res;
    }

    public function checkIBAN($iban) {
        if (preg_match('/^[A-Z]{2}[0-9]{2}[A-Z0-9]{1,30}$/', $iban)) {
            $country = substr($iban, 0, 2);
            $check = intval(substr($iban, 2, 2));
            $account = substr($iban, 4);
        

            $search = range('A','Z');
            foreach (range(10,35) as $tmp) {
                $replace[]=strval($tmp);
            }
            
            $numstr=str_replace($search, $replace, $account.$country.'00');
            $checksum = intval(substr($numstr, 0, 1));
            for ($pos = 1; $pos < strlen($numstr); $pos++) {
                $checksum *= 10;
                $checksum += intval(substr($numstr, $pos,1));
                $checksum %= 97;
            }
    
        return ((98-$checksum) == $check);
        } else {
            return false;
        }
    }
}