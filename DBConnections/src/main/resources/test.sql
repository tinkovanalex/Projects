--Premium Entry
select ps.id policyId,ps.policyNumber,c.id coverage,c.coverageCd,c.oid covOID,ps.txType,ps.txSubType,ps.oosTxType,tv.oid riskItem,
CONCAT(tax.CODE, fee.CODE) code,
CONCAT(tr.AMOUNT, fr.AMOUNT) amount,
CONCAT(tr.DENOMINATION,fr.DENOMINATION) denomination,
CONCAT(tr.APPLYLEVEL, fr.APPLYLEVEL) applyLevel,pe.premiumCd, pe.periodAmt,pe.premiumAmt,pe.changeAmt,pe.factor
from PremiumEntry pe
left OUTER join Coverage c on pe.Coverage_ID=c.id
LEFT OUTER join RiskItem tv on c.RiskItem_ID=tv.id
LEFT OUTER join PolicyDetail pd on tv.POLICYDETAIL_ID=pd.id
LEFT OUTER join PolicySummary ps on ps.policyDetail_id=pd.id
LEFT JOIN TAXRULE tr on pe.premiumCd = CAST(tr.id AS VARCHAR(20))
LEFT JOIN FEERULE fr on pe.premiumCd = CAST(fr.id AS VARCHAR(20))
LEFT JOIN TAX tax ON (tax.id = tr.TAX_ID)
LEFT JOIN FEE fee ON (fee.id = fr.FEE_ID)
where pe.PREMIUMCD not in ('CMR', 'CMS', 'NWT/R', 'RAW')
and
--c.COVERAGECD in ('PP','PL','LAC','MOLD','FRAUD', 'SEWER')and
--c.COVERAGECD not in ('WC', 'LOU') and
--c.COVERAGECD in ('PP', 'SEWER') and
--c.COVERAGECD in ('COMP', 'CSL') and
--c.COVERAGECD in ('UMPD', 'RREIM') and
--c.COVERAGECD in ('CSL', 'UMCSL') and
(ps.policyNumber = :policynumber )
order by ps.id, c.id,tv.oid,pe.premiumCd asc;


--Premium Entry Risk Item Level (New)
select ps.id policyId,ps.policyNumber,ps.txType,ps.txSubType,tv.oid riskItem,pe.premiumType,pe.premiumCd,
CONCAT(tax.CODE, fee.CODE) code,
CONCAT(tr.AMOUNT, fr.AMOUNT) amount,
CONCAT(tr.DENOMINATION,fr.DENOMINATION) denomination,
CONCAT(tr.APPLYLEVEL, fr.APPLYLEVEL) applyLevel,
pe.periodAmt,pe.premiumAmt,pe.changeAmt,pe.factor
from PremiumEntry pe
left OUTER join Coverage c on pe.Coverage_ID=c.id
LEFT OUTER join RiskItem tv on pe.RiskItem_ID=tv.id
LEFT OUTER join PolicyDetail pd on tv.POLICYDETAIL_ID=pd.id
LEFT OUTER join PolicySummary ps on ps.policyDetail_id=pd.id
LEFT JOIN TAXRULE tr on pe.premiumCd = CAST(tr.id AS VARCHAR(20))
LEFT JOIN FEERULE fr on pe.premiumCd = CAST(fr.id AS VARCHAR(20))
LEFT JOIN TAX tax ON (tax.id = tr.TAX_ID)
LEFT JOIN FEE fee ON (fee.id = fr.FEE_ID)
where pe.PREMIUMCD not in ('CMR', 'CMS', 'NWT/R', 'RAW')
and(ps.policyNumber = :policynumber )
order by ps.id, tv.oid,pe.premiumCd asc;


--Premium Entry Policy Level (New)
select ps.id policyId,ps.policyNumber,ps.producerCd,ps.subProducerCd,ps.txType,ps.txSubType,ps.oosTxType,ps.oid,pe.premiumType,pe.premiumCd,
CONCAT(tax.CODE, fee.CODE) code,
CONCAT(tr.AMOUNT, fr.AMOUNT) amount,
CONCAT(tr.DENOMINATION,fr.DENOMINATION) denomination,
CONCAT(tr.APPLYLEVEL, fr.APPLYLEVEL) applyLevel,
pe.periodAmt,pe.premiumAmt,pe.changeAmt,pe.factor
from PremiumEntry pe
LEFT OUTER join PolicySummary ps on pe.PolicySummary_ID=ps.id
LEFT JOIN TAXRULE tr on pe.premiumCd = CAST(tr.id AS VARCHAR(20))
LEFT JOIN FEERULE fr on pe.premiumCd = CAST(fr.id AS VARCHAR(20))
LEFT JOIN TAX tax ON (tax.id = tr.TAX_ID)
LEFT JOIN FEE fee ON (fee.id = fr.FEE_ID)
where pe.PREMIUMCD not in ('CMR', 'CMS', 'NWT/R', 'RAW')
and(ps.policyNumber = :policynumber)
order by ps.id asc;

--Premium Movement Cause and Premium Movement and Adjustment Movement
select pmc.id "premium movement cause id", pmc.prorateFactor,p.id "policy id", p.policyNumber, p.txType, pm.entityOid,pm.riskItemId,c.coverageCd, c.oid covOID,tv.oid riskItem,
pm.premiumLevel, pm.movementType, pm.grossPremiumChangeAmt,pm.netPremiumChangeAmt, pm.basePremiumChangeAmt,aj.adjustmentCd,aj.changeAmt adjustment
from PremiumMovementCause pmc
join PremiumMovement pm on pmc.id = pm.PremiumMovementCause_ID
left outer join AdjustmentMovement aj on pm.id = aj.PremiumMovement_ID
join PolicySummary p on p.id = pmc.transactionId
left outer join Coverage c on pm.coverageId = c.id
LEFT OUTER join RiskItem tv on c.RiskItem_ID=tv.id
where
--(pm.premiumLevel = 'policy')
--(pm.premiumLevel = 'coverage')
--and
pmc.transactionId in (
select p1.id
from PolicySummary p1
where p1.policyNumber = :policynumber)
order by p.id, pm.movementType asc;


--Ledger Entry
select le.transactiontype, le.PREMIUMCD, le.LEDGERACCOUNTNO, le.entrytype, sum(le.ENTRYAMT), le.POLICY_FK, le.PRODUCTNUMBER, le.ID, le.COVERAGECD, le.POSTINGLEVEL, le.COVERAGEOID
from ledgerentry le
where le.productnumber =:policynumber
and (le.ENTRYTYPE in ('CREDIT', 'DEBIT') and le.LEDGERACCOUNTNO in ('1044','1054','1053','1055','1056'))
group by le.transactiontype, le.PREMIUMCD, le.POLICY_FK, le.PRODUCTNUMBER,  le.LEDGERACCOUNTNO, le.entrytype, le.ID, le.COVERAGECD, le.POSTINGLEVEL, le.COVERAGEOID
order by le.ID, le.PREMIUMCD, productnumber, le.TRANSACTIONTYPE;