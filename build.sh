#!/bin/sh
export log_name="log-$(date +%Y%m%d%S-%s).txt"
make >> /tmp/$log_name 2>&1

function validate()
{
    return $(cat /tmp/$log_name|grep -i error|wc -l);
}

validate && echo "Aucune erreur."
validate || (echo "Erreurs : " ; cat /tmp/$log_name|grep -i error)
echo "Log complet : /tmp/$log_name"

