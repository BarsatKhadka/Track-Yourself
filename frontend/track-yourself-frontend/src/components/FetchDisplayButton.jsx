import { useQuery, useQueryClient } from "@tanstack/react-query"

export const FetchButton = ({onClick_post}) =>{
    
    return (
        <div>
            <button type="button" onClick={() => {onClick_post()}}>Add Memory</button>

        </div>
    )


}