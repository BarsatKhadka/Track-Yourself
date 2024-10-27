import './App.css';
import {useState , createContext ,useContext} from 'react'
import { MemoryList } from './components/MemoryList';
import {Navbar} from './components/Navbar'
import {QueryClient , QueryClientProvider} from '@tanstack/react-query'
import { AddMemory } from './components/AddMemory';


export const MemoryContext = createContext();

function App() {

 
  const [title,setTitle]  = useState("")
  const[description,setDescription] = useState("")

  const client = new QueryClient()

  return (
    
    <div className="App">
      <MemoryContext.Provider value = {{title , setTitle , description, setDescription}}>
      <QueryClientProvider client={client}>
      <Navbar/>
      <MemoryList/>
      </QueryClientProvider>
      </MemoryContext.Provider>
    </div>
    
  );
}

export default App;
