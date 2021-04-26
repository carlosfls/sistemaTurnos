USE [Empresa]
GO

/****** Object:  Table [dbo].[op_veh]    Script Date: 19/04/2021 03:56:49 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[op_veh](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[desc_operacion] [varchar](255) NULL,
	[op_id] [varchar](255) NULL,
	[turno_id] [bigint] NULL,
	[vehiculo_id] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

