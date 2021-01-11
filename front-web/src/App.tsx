import { Route } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './App.css';
import './Navbar';
import Routes from './Routes';

//React fragment: <> cria um bloco e o fragment não é representado no HTML - Não é possível retornar dois elementos na raiz de um component React
function App() {
  return (
    <>
      <Routes />
      <ToastContainer />
    </>
  );
}

export default App;
