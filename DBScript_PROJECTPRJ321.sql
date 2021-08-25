
create database [PRJ321_PROJECT]   
USE [PRJ321_PROJECT]
GO

/****** Object:  [PRJ321_PROJECT]    Script Date: 06/21/2019 21:49:07 ******/


GO
CREATE TABLE [dbo].[tblUser](
	[id] [int] IDENTITY(1,1),
	[username] [varchar](255) primary key,
	[password] [varchar](255) NULL,
	[fullName] [varchar](255) NULL,
	[idCardNumber] [varchar](255) NULL,
	[idCardType] [varchar](255) NULL,
	[address] [varchar](255) NULL,
	[description] [varchar](255) NULL
) ON [PRIMARY]

GO
CREATE TABLE [dbo].[tblProduct](
	[ProductID] int IDENTITY(1,1),
	[ProductName] [nvarchar](255) NOT NULL,
	[Unit] int NOT NULL,
	[Price] float NULL,
	[Image] image  NULL,
	[Detail] [nvarchar](255) NULL,
	[ProductCreateBy] [varchar](255) FOREIGN KEY REFERENCES tblUser(username)
 CONSTRAINT [PK_tblProduct] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[tblOrder](
	[OrderID] int IDENTITY(1,1),
	[CustomerIDbuy] [varchar](255) NOT NULL FOREIGN KEY REFERENCES tblUser(username),
	[CustomerIDsell] [varchar](255) NOT NULL FOREIGN KEY REFERENCES tblUser(username),
	[OrderDate] [datetime] NOT NULL,
 CONSTRAINT [PK_tblOrder] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
create table [dbo].[tblNumberOfCustomer](
[NumberOfAcount] int NOT NULL,
[NumberOfOrder] int NOT NULL,
[NumberOfProduct] int NOT NULL,
khoachinh varchar(20)
)

CREATE TABLE [dbo].[tblOrderItem](
	[OrderItemID] int IDENTITY(1,1),
	[OrderID] int FOREIGN KEY REFERENCES tblOrder(OrderID) ,
	[ProductID] int FOREIGN KEY REFERENCES tblProduct(ProductID),
	[Quantity] [int] NOT NULL,
 CONSTRAINT [PK_tblOrderItem] PRIMARY KEY CLUSTERED 
(
	[OrderItemID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
CREATE TABLE [dbo].[tblCart](
	[CartID] int IDENTITY(1,1) primary key,
	[username] [varchar](255) FOREIGN KEY REFERENCES tblUser(username),
	[ProductID] int FOREIGN KEY REFERENCES tblProduct(ProductID)
)
