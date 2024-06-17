/**
 * Autogenerated by Thrift Compiler (0.20.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package boba.microservice1.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.20.0)", date = "2024-05-14")
public class TraceContext implements org.apache.thrift.TBase<TraceContext, TraceContext._Fields>, java.io.Serializable, Cloneable, Comparable<TraceContext> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TraceContext");

  private static final org.apache.thrift.protocol.TField TRACE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("traceId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PARENT_SPAN_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("parentSpanId", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TraceContextStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TraceContextTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String traceId; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String parentSpanId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TRACE_ID((short)1, "traceId"),
    PARENT_SPAN_ID((short)2, "parentSpanId");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TRACE_ID
          return TRACE_ID;
        case 2: // PARENT_SPAN_ID
          return PARENT_SPAN_ID;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    @Override
    public short getThriftFieldId() {
      return _thriftId;
    }

    @Override
    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TRACE_ID, new org.apache.thrift.meta_data.FieldMetaData("traceId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PARENT_SPAN_ID, new org.apache.thrift.meta_data.FieldMetaData("parentSpanId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TraceContext.class, metaDataMap);
  }

  public TraceContext() {
  }

  public TraceContext(
    java.lang.String traceId,
    java.lang.String parentSpanId)
  {
    this();
    this.traceId = traceId;
    this.parentSpanId = parentSpanId;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TraceContext(TraceContext other) {
    if (other.isSetTraceId()) {
      this.traceId = other.traceId;
    }
    if (other.isSetParentSpanId()) {
      this.parentSpanId = other.parentSpanId;
    }
  }

  @Override
  public TraceContext deepCopy() {
    return new TraceContext(this);
  }

  @Override
  public void clear() {
    this.traceId = null;
    this.parentSpanId = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getTraceId() {
    return this.traceId;
  }

  public TraceContext setTraceId(@org.apache.thrift.annotation.Nullable java.lang.String traceId) {
    this.traceId = traceId;
    return this;
  }

  public void unsetTraceId() {
    this.traceId = null;
  }

  /** Returns true if field traceId is set (has been assigned a value) and false otherwise */
  public boolean isSetTraceId() {
    return this.traceId != null;
  }

  public void setTraceIdIsSet(boolean value) {
    if (!value) {
      this.traceId = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getParentSpanId() {
    return this.parentSpanId;
  }

  public TraceContext setParentSpanId(@org.apache.thrift.annotation.Nullable java.lang.String parentSpanId) {
    this.parentSpanId = parentSpanId;
    return this;
  }

  public void unsetParentSpanId() {
    this.parentSpanId = null;
  }

  /** Returns true if field parentSpanId is set (has been assigned a value) and false otherwise */
  public boolean isSetParentSpanId() {
    return this.parentSpanId != null;
  }

  public void setParentSpanIdIsSet(boolean value) {
    if (!value) {
      this.parentSpanId = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TRACE_ID:
      if (value == null) {
        unsetTraceId();
      } else {
        setTraceId((java.lang.String)value);
      }
      break;

    case PARENT_SPAN_ID:
      if (value == null) {
        unsetParentSpanId();
      } else {
        setParentSpanId((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TRACE_ID:
      return getTraceId();

    case PARENT_SPAN_ID:
      return getParentSpanId();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  @Override
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case TRACE_ID:
      return isSetTraceId();
    case PARENT_SPAN_ID:
      return isSetParentSpanId();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof TraceContext)
      return this.equals((TraceContext)that);
    return false;
  }

  public boolean equals(TraceContext that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_traceId = true && this.isSetTraceId();
    boolean that_present_traceId = true && that.isSetTraceId();
    if (this_present_traceId || that_present_traceId) {
      if (!(this_present_traceId && that_present_traceId))
        return false;
      if (!this.traceId.equals(that.traceId))
        return false;
    }

    boolean this_present_parentSpanId = true && this.isSetParentSpanId();
    boolean that_present_parentSpanId = true && that.isSetParentSpanId();
    if (this_present_parentSpanId || that_present_parentSpanId) {
      if (!(this_present_parentSpanId && that_present_parentSpanId))
        return false;
      if (!this.parentSpanId.equals(that.parentSpanId))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetTraceId()) ? 131071 : 524287);
    if (isSetTraceId())
      hashCode = hashCode * 8191 + traceId.hashCode();

    hashCode = hashCode * 8191 + ((isSetParentSpanId()) ? 131071 : 524287);
    if (isSetParentSpanId())
      hashCode = hashCode * 8191 + parentSpanId.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TraceContext other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetTraceId(), other.isSetTraceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTraceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.traceId, other.traceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetParentSpanId(), other.isSetParentSpanId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParentSpanId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parentSpanId, other.parentSpanId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  @Override
  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  @Override
  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TraceContext(");
    boolean first = true;

    sb.append("traceId:");
    if (this.traceId == null) {
      sb.append("null");
    } else {
      sb.append(this.traceId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("parentSpanId:");
    if (this.parentSpanId == null) {
      sb.append("null");
    } else {
      sb.append(this.parentSpanId);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TraceContextStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TraceContextStandardScheme getScheme() {
      return new TraceContextStandardScheme();
    }
  }

  private static class TraceContextStandardScheme extends org.apache.thrift.scheme.StandardScheme<TraceContext> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, TraceContext struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TRACE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.traceId = iprot.readString();
              struct.setTraceIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PARENT_SPAN_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.parentSpanId = iprot.readString();
              struct.setParentSpanIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, TraceContext struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.traceId != null) {
        oprot.writeFieldBegin(TRACE_ID_FIELD_DESC);
        oprot.writeString(struct.traceId);
        oprot.writeFieldEnd();
      }
      if (struct.parentSpanId != null) {
        oprot.writeFieldBegin(PARENT_SPAN_ID_FIELD_DESC);
        oprot.writeString(struct.parentSpanId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TraceContextTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public TraceContextTupleScheme getScheme() {
      return new TraceContextTupleScheme();
    }
  }

  private static class TraceContextTupleScheme extends org.apache.thrift.scheme.TupleScheme<TraceContext> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TraceContext struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTraceId()) {
        optionals.set(0);
      }
      if (struct.isSetParentSpanId()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetTraceId()) {
        oprot.writeString(struct.traceId);
      }
      if (struct.isSetParentSpanId()) {
        oprot.writeString(struct.parentSpanId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TraceContext struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.traceId = iprot.readString();
        struct.setTraceIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.parentSpanId = iprot.readString();
        struct.setParentSpanIdIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

