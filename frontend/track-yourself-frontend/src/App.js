import './App.css';
import {useState , createContext ,useContext} from 'react'
import { MemoryList } from './components/MemoryList';
import {QueryClient , QueryClientProvider} from '@tanstack/react-query'

export const MemoryContext = createContext();

function App() {

 
  const [memories , setMemories] = useState("memories")

  const client = new QueryClient()

  return (
    
    <div className="App">
      <MemoryContext.Provider value = {{memories , setMemories}}>
      <QueryClientProvider client={client}>
      <h1>Track Yourself</h1>
      <MemoryList/>
      </QueryClientProvider>
      </MemoryContext.Provider>
    </div>
    
  );
}

export default App;
