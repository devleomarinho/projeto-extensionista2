import { Link } from 'react-router-dom';
import '../Estilos/home.css'

function MainPage() {
  return (
    <div className='app-content'>
      <div className="start-div">
        <h1>COMECE AGORA!</h1>
        <Link type="button" to='/game' className='button'>iniciar</Link>
      </div>
      <div className="pac-gif">
        <img src="../public/imagens/pacman-beaneater.gif" alt="Pac Kids GIF" />
      </div>
    </div>
  )
}

export default MainPage;