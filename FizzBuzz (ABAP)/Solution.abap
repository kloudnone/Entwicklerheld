* <SIGNATURE>---------------------------------------------------------------------------------------+
* | Static Public Method RUN
* +-------------------------------------------------------------------------------------------------+
* | [--->] IV_NUMBER                      TYPE        INT4
* | [()->] OUT	                        TYPE REF TO if_oo_adt_classrun_out
* | [<-()] RV_RESULT                      TYPE        STRING
* +--------------------------------------------------------------------------------------</SIGNATURE>
    IF IV_NUMBER MOD 15 = 0.
        RV_RESULT = 'fizzbuzz'.
    ELSEIF IV_NUMBER MOD 3 = 0.
        RV_RESULT = 'fizz'.
    ELSEIF IV_NUMBER MOD 5 = 0.
        RV_RESULT = 'buzz'.
    ELSE.
        RV_RESULT = IV_NUMBER.
    ENDIF.