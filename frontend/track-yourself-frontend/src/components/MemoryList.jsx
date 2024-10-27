import { useContext, useEffect } from "react"
import { MemoryContext } from "../App"
import { useQuery } from "@tanstack/react-query"
import axios from "axios"

export const MemoryList = () =>{
    const {memories,setMemories} = useContext(MemoryContext)

    const {data , isLoading , refetch} = useQuery(
        {
            queryKey: "memories",
            queryFn: async ()=> {
                try{
                    const response =  await axios.get("http://localhost:8080/track/memories")
                    return response.data
                }
                catch(err){
                    return (err.response ? err.response.data : "An error occured during the fetching process")
                }

            }
        }
    )


    if (isLoading) {
        return <div>Loading...</div>;
      }
      


    return (
        <div>
            <button onClick={refetch}>choose your poison</button>

            {data.map((memory) =>{
                return (
                    <div>
                        

                        {memory.description}

                    </div>
                )


            })}
            
        
        </div>
    )

}