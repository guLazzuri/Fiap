--  Gustavo Ramires Lazzuri       RM556772          1TDSPI 
--  Gabriela de Sousa Reis        RM558830          1TDSPJ
--  Laura Amadeu                  RM556690          1TDSPJ  

-- Quest�o 1
SELECT 
    tf.nome AS "Nome do Tipo de Fonte", 
    COUNT(ps.id_projeto) AS "Quantidade de Projetos"
FROM 
    PF0645.projetos_sustentaveis ps
JOIN 
    PF0645.tipo_fontes tf ON ps.id_tipo_fonte = tf.id_tipo_fonte
GROUP BY 
    tf.nome
HAVING 
    COUNT(ps.id_projeto) > 2
ORDER BY 
    "Nome do Tipo de Fonte";


-- Questão 2
SELECT p.id_projeto AS ID_Projeto,
       p.descricao AS Descricao,
       p.custo AS Custo
FROM PF0645.projetos_sustentaveis p
JOIN PF0645.tipo_fontes t ON p.ID_TIPO_FONTE = t.ID_TIPO_FONTE
WHERE t.nome IN ('Solar', 'Eólica')
ORDER BY NLSSORT(p.descricao, 'NLS_SORT=BINARY_AI');


-- Quest�o 3
SELECT id_projeto AS ID_Projeto,
       descricao AS Descricao,
       status AS Status
FROM PF0645.projetos_sustentaveis
WHERE custo > 500000
  AND status = 'Em andamento'
ORDER BY ID_Projeto;

-- Quest�o 4
SELECT r.nome AS Nome_Regiao,
       ROUND(AVG(p.custo), 2) AS Media_Custo
FROM PF0645.projetos_sustentaveis p
JOIN PF0645.regioes_sustentaveis r ON p.ID_REGIAO = r.ID_REGIAO
GROUP BY r.nome
ORDER BY Media_Custo DESC;


-- Quest�o 5
SELECT 
    r.nome AS regiao,
    tf.nome,
    COUNT(p.id_projeto) AS qtd_projetos,
    ROUND(AVG(ec.emissao), 2) AS media_emissoes
FROM 
    PF0645.regioes_sustentaveis r
JOIN 
    PF0645.projetos_sustentaveis p ON p.id_regiao = r.id_regiao  
JOIN 
    PF0645.tipo_fontes tf ON tf.id_tipo_fonte = p.id_tipo_fonte
JOIN 
    PF0645.emissoes_carbono ec ON ec.id_tipo_fonte = tf.id_tipo_fonte
GROUP BY 
    r.nome, tf.nome
HAVING 
    AVG(ec.emissao) > 5000
ORDER BY 
    r.nome ASC, tf.nome ASC;




