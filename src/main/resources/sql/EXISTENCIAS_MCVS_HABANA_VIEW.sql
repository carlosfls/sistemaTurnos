ALTER VIEW EXISTENCIAS_MCVS_HABANA AS 
SELECT Producto.Id_Producto,Id_Categoria,Desc_Producto,Id_Almacen,Existencia_Actual
FROM MCVS_HABANA.dbo.Producto JOIN MCVS_HABANA.dbo.Existencia ON
Producto.Id_Producto=Existencia.Id_Producto
WHERE Existencia_Actual > 0 AND Producto_oServicio = 'true'      
