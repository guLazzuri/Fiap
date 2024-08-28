import { createRoot } from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import { StrictMode } from 'react'
import GlobalStyle from './global-styled.ts'


createRoot(document.getElementById('root')!).render(
    
    <StrictMode>
     <App /> 
    <GlobalStyle/>
    </StrictMode>
  
)
