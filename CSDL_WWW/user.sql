USE [master]
GO
/****** Object:  Database [security_project_nuoc_hoa]    Script Date: 12/05/2022 4:16:19 CH ******/
CREATE DATABASE [security_project_nuoc_hoa]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'security_project_nuoc_hoa', FILENAME = N'C:\DATA\security_project_nuoc_hoa.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'security_project_nuoc_hoa_log', FILENAME = N'C:\DATA\security_project_nuoc_hoa_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [security_project_nuoc_hoa] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [security_project_nuoc_hoa].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [security_project_nuoc_hoa] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET ARITHABORT OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET  DISABLE_BROKER 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET RECOVERY FULL 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET  MULTI_USER 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [security_project_nuoc_hoa] SET DB_CHAINING OFF 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [security_project_nuoc_hoa] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'security_project_nuoc_hoa', N'ON'
GO
ALTER DATABASE [security_project_nuoc_hoa] SET QUERY_STORE = OFF
GO
USE [security_project_nuoc_hoa]
GO
/****** Object:  Table [dbo].[authorities]    Script Date: 12/05/2022 4:16:19 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[authorities](
	[username] [varchar](50) NULL,
	[authority] [varchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 12/05/2022 4:16:19 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](68) NULL,
	[enabled] [tinyint] NULL,
 CONSTRAINT [PK_users] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[authorities] ([username], [authority]) VALUES (N'mary', N'ROLE_MANAGER')
INSERT [dbo].[authorities] ([username], [authority]) VALUES (N'susan', N'ROLE_EMPLOYEE')
INSERT [dbo].[authorities] ([username], [authority]) VALUES (N'david', N'ROLE_ADMIN')
INSERT [dbo].[authorities] ([username], [authority]) VALUES (N'thangkhongngu', N'ROLE_CUSTOMER')
INSERT [dbo].[authorities] ([username], [authority]) VALUES (N'duc', N'ROLE_CUSTOMER')
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'david', N'{bcrypt}$2a$10$taWQj6qf.fAkjbHGfMAG3ujTAdCDl/d40/8dzi0hQRQxNzBmecjv6', 1)
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'duc', N'{bcrypt}$2a$10$cjzyxq0sAarG/kIeU8S3r.ZEHgxLh.fgSIN2h4Y52PQCD6XgsbsNW', 1)
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'mary', N'{bcrypt}$2a$10$12tNGY/2mOywEOYufGcLnuICjFl/Z3F/FWl4UAq2zcqUwZbFm/mdW', 1)
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'susan', N'{bcrypt}$2a$10$9bWMlwdxwB.y6cUMSNjXTe4sFqkhWqXZSQpsKs6Pz6BbXklMggEl6', 1)
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'thangkhongngu', N'{bcrypt}$2a$10$lncW.nojPiRww4tKa4Kv7e5bVMUmXGcwBcw5T99bpT1GZYl2QFH.2', 1)
ALTER TABLE [dbo].[authorities]  WITH CHECK ADD  CONSTRAINT [FK_authorities_users] FOREIGN KEY([username])
REFERENCES [dbo].[users] ([username])
GO
ALTER TABLE [dbo].[authorities] CHECK CONSTRAINT [FK_authorities_users]
GO
USE [master]
GO
ALTER DATABASE [security_project_nuoc_hoa] SET  READ_WRITE 
GO
