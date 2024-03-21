import type { Metadata } from "next"
import "./index.css"
import { ThemeProvider } from "@mui/material"
import { theme } from "@/theme"
import { Header } from "@/components/Header/Header"
import { Footer } from "@/components/Footer/Footer"

export const metadata: Metadata = {
  title: "Quick Project",
  description: "Generated by create next app",
}

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode
}>) {
  return (
    <html lang="ru">
      <body>
        <ThemeProvider theme={theme}>
          <Header />
          {children}
          <Footer />
        </ThemeProvider>
      </body>
    </html>
  )
}
