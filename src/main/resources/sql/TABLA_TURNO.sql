USE [Empresa]
GO

/****** Object:  Table [dbo].[turno]    Script Date: 19/04/2021 03:57:41 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[turno](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[desc_cliente] [varchar](255) NULL,
	[desc_empleado] [varchar](255) NULL,
	[desc_vehiculo] [varchar](255) NULL,
	[fecha_llegada] [datetime2](7) NULL,
	[modelo] [varchar](255) NULL,
	[observaciones] [varchar](255) NULL,
	[tipo_servicio] [varchar](255) NULL,
	[tipo_vehiculo] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

