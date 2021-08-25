USE [hotelmanagement]
GO

/****** Object:  Table [dbo].[tblUser]    Script Date: 6/30/2021 5:28:25 PM ******/

ALTER TABLE tblOrderItem
ADD FOREIGN KEY (ProductID) REFERENCES tblProduct(ProductID);

ALTER TABLE tblNumberOfCustomer
ADD khoachinh varchar(20);

