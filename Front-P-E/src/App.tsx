
import './App.css'
import { Outlet } from 'react-router-dom';

function App() {
  
  //App e conteudo das paginas inseridos no componente Outlet pelo react-router-dom
  return (
    <div className="app-container">
      <Outlet/>
    </div>
  )
}

export default App
