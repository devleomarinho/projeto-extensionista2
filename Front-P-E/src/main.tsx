import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'

//import das rotas
import ErrorPage from './Rotas/ErrorPage.tsx'
import Enter from './Rotas/Enter.tsx'
import Login from './Rotas/Login.tsx'
import Register from './Rotas/Register.tsx'
import Home from './Rotas/Home.tsx'
import Game from './Rotas/Game.tsx'



//Variável de router providers para navegação entre paginas 
const router = createBrowserRouter([
  {
    path: '/',
    element: <App/>,
    errorElement: <ErrorPage />,
    children: [
      {
        path: '/',
        element: <Enter />,
      },
      {
        path: '/login',
        element: <Login />,
      },
      {
        path: '/register',
        element: <Register />,
      },
      {
        path: '/home',
        element: <Home />,
      },
      {
        path: '/game',
        element: <Game />,
      },
    ]
  }
])

//Renderização das paginas com router provider
createRoot(document.getElementById('root')!).render(
  <StrictMode>
        <RouterProvider router={router} />
  </StrictMode>,
)
