import { useState } from "react";
import Multiselect from "multiselect-react-dropdown";

function DropdownComponent() {
  const [Artists, setArtists] = useState(["Zayn Malik", "Justin Beiber", "Weekend","Lil nas x","Harry styles","John Legend"]);

  return (
    <div className="App">
      <Multiselect
        isMulti = {true}
        isObject={false}
        onRemove={(event) => {
          console.log(event);
        }}
        onSelect={(event) => {
          console.log(event);
        }}
        options={Artists}
        selectedValues={["Zayn Malik","Harry Styles","John Legend"]}
        showCheckbox
      />
    </div>
  );
}

export default DropdownComponent;